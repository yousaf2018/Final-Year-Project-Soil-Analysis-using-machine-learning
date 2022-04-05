import pymodbus
from pymodbus.client.sync import ModbusSerialClient
from pymodbus.payload import BinaryPayloadBuilder
from pymodbus.payload import BinaryPayloadDecoder 
from pymodbus.constants import Endian
import numpy as np
import time
import pyrebase
#Firebase configration 
config = {
    "apiKey": "AIzaSyA86tdqn6cSZG8Ea3YVVckwqw-difzXiqE",
    "authDomain": "meri-zameen-9faef.firebaseapp.com",
    "projectId": "meri-zameen-9faef",
    "databaseURL": "https://meri-zameen-9faef-default-rtdb.firebaseio.com/",
    "storageBucket": "meri-zameen-9faef.appspot.com",
    "messagingSenderId": "139021870833",
    "appId": "1:139021870833:web:31c0ccbf34ff7b61d46b50",
    "measurementId": "G-X5G6JV59YK"
}
#Getting firebase instance 
firebase = pyrebase.initialize_app(config)
database = firebase.database()
Unique = "Sensor01"
# data = {"pH":7.8, "OM":5.4}

# database.child(Unique).set(data)

# Res = database.child(Unique).get()
# print(type(Res))
# for x in Res.each():
#     print( x.key(), x.val() )
client= ModbusSerialClient(method = "rtu", port="/dev/ttyUSB0",stopbits = 1, bytesize = 8, parity = 'N', baudrate= 4800)


client.connect()
print("Client is connected successfully")

def read_float(start_add, count):
    res = client.read_holding_registers(address=start_add,count=count, unit=1)
    return res



while True:
    try:
        result = read_float(0000,20)
        #Reading values from registers NPK sensor
        Humidity = result.registers[0]/10
        Temperature = result.registers[1]/10
        EC = result.registers[2]/10
        pH = result.registers[3]/10
        N = result.registers[4]/10
        P = result.registers[5]/10
        K = result.registers[6]/10
        print("**********************************")
        print(f"Humidity: {Humidity}")
        print(f"Temperature: {Temperature}")
        print(f"EC: {EC}")
        print(f"pH: {pH}")
        print(f"Nitrogen: {N}")
        print(f"Phosphorous: {P}")
        print(f"Potassium: {K}")
        print("**********************************")
        data = {"pH":pH, "EC":EC, "N":N, "P":P, "K":K, "Humidity":Humidity, "Temperature":Temperature, "Flag":True}
        database.child(Unique).set(data)
        time.sleep(1)
        # with open("Output.txt", "w") as f:
        #     f.write("**********************************\n")
        #     f.write("Humidity: "+str(Humidity)+"\n")
        #     f.write("**********************************\n")
        #     # print(f"Temperature: {Temperature}")
        #     # print(f"EC: {EC}")
        #     # print(f"pH: {pH}")
        #     # print(f"Nitrogen: {N}")
        #     # print(f"Phosphorous: {P}")
        #     # print(f"Potassium: {K}")
        #     # print("**********************************")
    except:
        print("Trying for getting connection with sensor")
        data = {"pH":0.0, "EC":0.0, "N":0.0, "P":0.0, "K":0.0, "Humidity":0.0, "Temperature":0.0, "Flag":False}
        database.child(Unique).set(data)
        continue

