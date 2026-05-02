import pyttsx3
import datetime

friday = pyttsx3.init()

# Sửa lỗi chính tả 'voice'
voices = friday.getProperty('voices')
friday.setProperty('voice', voices[0].id) 

def speak(audio):
    print("Tro li : " + audio)
    friday.say(audio)
    friday.runAndWait()

def welcome():
    hour = datetime.datetime.now().hour
    greeting = ""
    
    if 6 <= hour <= 12:
        greeting = "Good morning. "
    elif 12 < hour < 24:
        greeting = "Good evening baby. "
    else:
        greeting = "Good night baby. "
    
    # Gộp các câu lại thành một chuỗi dài để nói mượt mà hơn
    full_message = greeting + "How can I help you"
    speak(full_message)
    speak(hour)

# Gọi hàm test
welcome()