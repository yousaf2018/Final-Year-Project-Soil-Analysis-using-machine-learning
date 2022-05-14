from flask import Flask, jsonify, request
import pickle
import numpy as np
import cv2    
from PIL import Image
import base64

Pmodel = pickle.load(open('Pclassifier.pkl', 'rb'))
pHmodel = pickle.load(open('pHclassifier.pkl', 'rb'))
OMmodel = pickle.load(open('OMclassifier.pkl', 'rb'))
ECmodel = pickle.load(open('ECclassifier.pkl', 'rb'))

app = Flask(__name__)

@app.route('/')

def home():
    return "Serving service to mobile application with api to respond to image with analysis"

@app.route('/predict', methods = ['POST', "GET"])
def predict():
    if request.method == "POST":
        inputImage = request.form.get('inputImage')
        nparr = np.frombuffer(base64.b64decode(inputImage), np.uint8)
        image = cv2.imdecode(nparr, cv2.IMREAD_COLOR)

        print(image.shape)

        # extracting blue,red,green channel from color image
        blue_channel = image[:,:,0]
        green_channel = image[:,:,1]
        red_channel = image[:,:,2]
        temp = ((np.median(green_channel)+np.median(blue_channel))+np.median(red_channel))
        temp = np.nanmean(temp)
        Presult = float(Pmodel.predict([[temp]]))
        pHreuslt = float(pHmodel.predict([[temp]]))
        OMresult = float(OMmodel.predict([[temp]]))
        ECresult = float(ECmodel.predict([[temp]]))
        
        result = {'P':Presult, 'pH':pHreuslt, 'OM':OMresult, 'EC':ECresult } 
        return jsonify(result)
    else:
        return "API is running to handle android application requests"

if __name__ == '__main__':
    app.run(debug=True)
    

# #Ecoding image to base64
# with open("testing.jpg", "rb") as img_file:
#     b64_string = base64.b64encode(img_file.read())
# print(b64_string)
# with open("q1.txt","w+") as f:
#     f.write(b64_string.decode("utf-8"))



