from gradio_client import Client

client = Client("https://josh1920-llama2-7b-chat-hf-ggml.hf.space/")
result = client.predict(
        "Howdy!",	# str in 'User Query' Textbox component
        api_name="/predict"
)
print(result)