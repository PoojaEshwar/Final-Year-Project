import pyowm

owm = pyowm.OWM('b31ca156d5b319aaa3648f13af0b5637')  # You MUST provide a valid API key

# Have a pro subscription? Then use:
# owm = pyowm.OWM(API_key='your-API-key', subscription_type='pro')

# Search for current weather in London (Great Britain)
observation = owm.weather_at_place('Bengaluru,IN')
w = observation.get_weather()
temp = w.get_temperature('celsius')

def current_temperature():
    print(temp.get('temp'))
    return temp.get('temp')

