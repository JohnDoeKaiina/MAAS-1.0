import streamlit as st
from datetime import date

# Define the Streamlit app header
st.title("Pregnancy Diagnosis")

# Questions to diagnose pregnancy
questions = [
    "What is your age?",
    "When was your last period (MM/DD/YYYY)?",
    "How many children do you have?",
    "Have you experienced any of the following symptoms recently?",
    "Have you taken a home pregnancy test?",
]

# Initialize a dictionary to store user responses
user_responses = {}

# Ask the user the questions and collect responses
for question in questions:
    if "age" in question.lower():
        response = st.number_input(question, min_value=1, max_value=100, step=1)
    elif "last period" in question.lower():
        response = st.date_input(question)
    elif "children" in question.lower():
        response = st.number_input(question, min_value=0, step=1)
    else:
        response = st.radio(question, ["True", "False"])
    user_responses[question] = response

# Add a "Show Result" button to reveal the diagnosis
if st.button("Show Result"):
    # Calculate the diagnosis based on the user responses
    age = user_responses["What is your age?"]
    last_period = user_responses["When was your last period (MM/DD/YYYY)?"]
    children = user_responses["How many children do you have?"]
    symptoms = user_responses["Have you experienced any of the following symptoms recently?"]
    pregnancy_test = user_responses["Have you taken a home pregnancy test?"]

    # Calculate the number of months since the last period
    today = date.today()
    months_since_last_period = (today.year - last_period.year) * 12 + (today.month - last_period.month)

    # Define the pregnancy diagnosis algorithm
    # This is a simplified example, and you should consult with a healthcare professional for an accurate diagnosis.
    if age >= 18 and months_since_last_period > 0 and children == 0 and symptoms == "True" and pregnancy_test == "True":
        diagnosis = "Based on your age, last period, childbearing history, symptoms, and pregnancy test, you might be pregnant."
    elif age < 18:
        diagnosis = "Based on your age, it is not recommended to become pregnant."
    else:
        diagnosis = "Based on the information provided, it's inconclusive. Consult a healthcare professional for a precise diagnosis."

    # Display the diagnosis
    st.subheader("Diagnosis:")
    st.write(diagnosis)
