from pymodbus.client.sync import ModbusSerialClient
from pymodbus.payload import BinaryPayloadBuilder
from pymodbus.payload import BinaryPayloadDecoder 
from pymodbus.constants import Endian
import numpy as np
import time

client= ModbusSerialClient(method = "rtu", port="COM4",stopbits = 1, bytesize = 8, parity = 'N', baudrate= 4800)


client.connect()


def read_float(start_add, count):
    res = client.read_holding_registers(address=start_add,count=count, unit=1)
    return res



while True:
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
    time.sleep(1)

