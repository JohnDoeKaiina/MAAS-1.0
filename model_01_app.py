import streamlit as st
import tensorflow as tf
import numpy as np
from PIL import Image




#to be updated
import requests
from keras.preprocessing.image import load_img, img_to_array
from keras.models import load_model
import numpy as np
from io import BytesIO

# Define the URL of the HDF5 model file
model_url = "URL_OF_YOUR_MODEL.hdf5"

# Load the Keras model from the URL
model = load_model(model_url)

url_list = [
    # Add your list of image URLs here
    # ...
]

for url in url_list:
    response = requests.get(url)
    img = load_img(BytesIO(response.content), target_size=(IMG_WIDTH, IMG_HEIGHT))
    img = img_to_array(img)
    img = np.expand_dims(img, axis=0)

    classes = model.predict(img, batch_size=10)
    print(classes[0][0])
    if classes[0][0] > 0.5:
        print(url + " is PNEUMONIA case")
    else:
        print(url + " is NORMAL case")
