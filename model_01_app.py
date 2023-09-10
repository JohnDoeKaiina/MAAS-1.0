import streamlit as st
import tensorflow as tf
import numpy as np
from PIL import Image

from tensorflow import keras
# Load the pre-trained model
model = keras.models.load_model('models/model_01.hdf5')

# Create a function to classify an image
def classify_image(image):
  prediction = model.predict(image)
  return prediction

# Create a Streamlit app
st.title('Image Classification App')

# Upload an image
image = st.file_uploader('Upload an image')

# Classify the image
if image is not None:
  image = np.array(Image.open(image))
  prediction = classify_image(image)
  st.write('The image is classified as:', prediction)
