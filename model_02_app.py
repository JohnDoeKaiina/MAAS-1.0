import streamlit as st

# Define the Streamlit app header
st.title("Common Cold Diagnosis")

# Questions to diagnose a common cold
questions = [
    "Do you have a runny or stuffy nose?",
    "Are you experiencing a sore throat?",
    "Do you have a cough?",
    "Are you sneezing frequently?",
    "Are you experiencing any fatigue or general malaise?",
]

# Initialize a dictionary to store user responses
user_responses = {}

# Ask the user the questions and collect responses
for question in questions:
    response = st.radio(question, ["Yes", "No", "Not Sure"])
    user_responses[question] = response

# Add a "Show Result" button to reveal the diagnosis
if st.button("Show Result"):
    # Calculate the diagnosis
    num_yes = sum([1 for response in user_responses.values() if response == "Yes"])

    if num_yes >= 3:
        diagnosis = "It's likely you have a common cold."
    else:
        diagnosis = "It's less likely you have a common cold."

    # Display the diagnosis
    st.subheader("Diagnosis:")
    st.write(diagnosis)
