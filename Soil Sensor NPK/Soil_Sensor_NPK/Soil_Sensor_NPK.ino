#include <SoftwareSerial.h> //Library to convert Digital Output pins of the board to transmitter as well as receiver
#define RE 8
#define DE 7
//REQUEST FRAME
const byte inq[] = {0x01, 0x03, 0x00, 0x00, 0x00, 0x07, 0x04, 0x08}; 
//And the response data frame are for all those values: hum,temp, ec, ph, n, p, k like in the attach image
byte values[38];
SoftwareSerial mod(2,3); // RX, TX ( Creates a new SoftwareSerial object )
void setup(){
  Serial.begin(9600);
  mod.begin(9600);  
  pinMode(RE, OUTPUT);
  pinMode(DE, OUTPUT);
} 
void loop(){
  float val1;
  val1 = Hum();
  delay(2000); 
}
float Hum(){  
  digitalWrite(DE,HIGH);
  digitalWrite(RE,HIGH);
  delay(10);
  if(mod.write(inq,sizeof(inq))==8){
    digitalWrite(DE,LOW);
    digitalWrite(RE,LOW);
    // now we will read the response frame, and store the values in the values[] arrary, we will be using a for loop.
    Serial.print("Response from sensor");
    Serial.println();
    for(byte i=0;i<38;i++){
//    Serial.print(mod.read(),HEX);
      values[i] = mod.read();
      Serial.print(values[i],HEX);
//    //the values for: hum,temp, ec, ph, n, p, k
//    Serial.print(" hum ");
//    Serial.print(values[4]);
//    Serial.print(" % ");
//    Serial.print(" temp ");
//    Serial.print(values[5]);
//    Serial.print(" º ");
//    Serial.print(" ec ");
//    Serial.print(values[6]);
//    Serial.print("  ");
//    Serial.print(" ph ");
//    Serial.print(values[7]);
//    Serial.print(" ");
//    Serial.print(" n ");
//    Serial.print(values[8]);
//    Serial.print("  ");
//    Serial.print(" p ");
//    Serial.print(values[9]);
//    Serial.print("  ");
//    Serial.print(" k ");
//    Serial.print(values[10]);
//    Serial.print(" ");
//    delay(2000);
    }
  }
  return (values[4]);   //this is only for HUMIDITY VALUE
}
