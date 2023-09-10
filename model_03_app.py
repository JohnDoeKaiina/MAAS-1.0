import streamlit as st

# Define the Streamlit app header
st.title("Pregnancy Diagnosis")

# Questions to diagnose pregnancy
questions = [
    "What is your age?",
    "When was your last period (MM/DD/YYYY)?",
    "How many children do you have?",
]

# Initialize a dictionary to store user responses
user_responses = {}

# Ask the user the questions and collect responses
for question in questions:
    if "age" in question.lower():
        response = st.number_input(question, min_value=1, max_value=100, step=1)
    elif "last period" in question.lower():
        response = st.date_input(question)
    else:
        response = st.number_input(question, min_value=0, step=1)
    user_responses[question] = response

# Add a "Show Result" button to reveal the diagnosis
if st.button("Show Result"):
    # Calculate the diagnosis based on the user responses
    age = user_responses["What is your age?"]
    last_period = user_responses["When was your last period (MM/DD/YYYY)?"]
    children = user_responses["How many children do you have?"]

    # Add your pregnancy diagnosis logic here
    # You can use the user's age, last period date, and childbearing history to make the diagnosis
    # Example:
    if age >= 18 and children == 0:
        diagnosis = "Based on your age and childbearing history, you might be eligible for pregnancy."
    elif age < 18:
        diagnosis = "Based on your age, it is not recommended to become pregnant."
    else:
        diagnosis = "Based on the information provided, it's inconclusive. Consult a healthcare professional for a precise diagnosis."

    # Display the diagnosis
    st.subheader("Diagnosis:")
    st.write(diagnosis)
