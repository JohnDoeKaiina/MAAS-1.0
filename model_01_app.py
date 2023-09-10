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


    #img = load_img(BytesIO(response.content), target_size=(IMG_WIDTH, IMG_HEIGHT))
    #img = img_to_array(img)
    #img = np.expand_dims(img, axis=0)
    
	#image = tf.cast(image, tf.float32)
	
	image = tf.image.resize(image, [150, 150])
	image = np.expand_dims(image, axis = 0)
	prediction = model.predict(image,batch_size=10)

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
