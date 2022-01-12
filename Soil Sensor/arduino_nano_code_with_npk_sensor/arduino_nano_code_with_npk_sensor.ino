#include <SoftwareSerial.h>
#include <Wire.h>
 
#define RE 8
#define DE 7
 
//const byte ec[] = {0x01, 0x03, 0x00, 0x15, 0x00, 0x01, 0x95, 0xCE};
const byte moisture[] = {0x01, 0x03, 0x00, 0x00, 0x00, 0x07, 0x04, 0x08};
int values[38];
 
SoftwareSerial mod(2, 3);
 
void setup()
{
  Serial.begin(9600);
  mod.begin(9600);
  pinMode(RE, OUTPUT);
  pinMode(DE, OUTPUT);
}
 
void loop()
{
/**************Soil Moisture Reading*******************/  
 digitalWrite(DE, HIGH);
  digitalWrite(RE, HIGH);
  delay(10);
 
  if (mod.write(moisture, sizeof(moisture)) == 8)
  {
    digitalWrite(DE, LOW);
    digitalWrite(RE, LOW);
    for (int i = 0; i < 38; i++)
    {
      values[i] = mod.read();
      Serial.print(values[i], DEC);
    }
    Serial.println();
  }
  delay(1000);
}
