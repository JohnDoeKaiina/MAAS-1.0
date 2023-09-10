import streamlit as st
import requests
import tensorflow as tf
import numpy as np
from PIL import Image
from io import BytesIO

# Constants
IMG_WIDTH = 150
IMG_HEIGHT = 150

# Load the pre-trained model
model = tf.keras.models.load_model('./models/sequential_0910_0309')

def classify_image(image):
    img = Image.open(BytesIO(image))
    img = img.resize((IMG_WIDTH, IMG_HEIGHT))
    img = np.array(img)
    img = np.expand_dims(img, axis=0)

    shape = img.shape
    st.write("The shape of your input is:", shape)

    #classes = model.predict(img, batch_size=10)
    #return classes[0][0]

def main():
    st.title("Pneumonia Detection App")
    st.sidebar.header("Settings")

    # Option to upload an image
    uploaded_image = st.sidebar.file_uploader("Upload an image", type=["jpg", "jpeg", "png"])

    # Option to enter a list of URLs
    url_list = st.sidebar.text_area("Enter a list of image URLs (one URL per line)")

    if uploaded_image is not None:
        st.sidebar.text("Uploaded Image:")
        st.sidebar.image(uploaded_image, use_column_width=True)
        image = uploaded_image.read()
        result = classify_image(image)
        st.write("Prediction:")
        if result > 0.5:
            st.write("This image is a PNEUMONIA case.")
        else:
            st.write("This image is a NORMAL case.")

    elif url_list:
        url_list = url_list.split("\n")
        for url in url_list:
            if url.strip() == "":
                continue
            response = requests.get(url)
            if response.status_code == 200:
                image = response.content
                result = classify_image(image)
                st.image(url, caption="URL Image", use_column_width=True)
                st.write("Prediction:")
                if result > 0.5:
                    st.write(f"{url} is a PNEUMONIA case.")
                else:
                    st.write(f"{url} is a NORMAL case.")
            else:
                st.write(f"Unable to fetch image from URL: {url}")

if __name__ == "__main__":
    main()
