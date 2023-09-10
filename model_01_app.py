import streamlit as st
import tensorflow as tf
import numpy as np
from PIL import Image


st.set_option('deprecation.showfileUploaderEncoding', False)

@st.cache(allow_output_mutation=True)
def load_model():
	model = tf.keras.models.load_model('./models/model_01.hdf5')
	return model


def predict_class(image, model):
    # Ensure that the image has 3 dimensions (height, width, channels)
    if len(image.shape) != 3:
        raise ValueError("Input image must have 3 dimensions (height, width, channels)")

    # Resize the image to the desired size
    image = tf.image.resize(image, [180, 180])
    
    # Convert the image to float32
    image = tf.cast(image, tf.float32)

    # Add an extra dimension to simulate batch size of 1
    image = np.expand_dims(image, axis=0)

    # Make the prediction
    prediction = model.predict(image)

    return prediction



model = load_model()
st.title('Flower Classifier')

file = st.file_uploader("Upload an image of a flower", type=["jpg", "png"])


if file is None:
	st.text('Waiting for upload....')

else:
	slot = st.empty()
	slot.text('Running inference....')

	test_image = Image.open(file)

	st.image(test_image, caption="Input Image", width = 400)

	pred = predict_class(np.asarray(test_image), model)

	class_names = ['daisy', 'dandelion', 'rose', 'sunflower', 'tulip']

	result = np.argmax(pred)
	
	output = 'The image is a ' + result

	slot.text('Done')

	st.success(output)
