import requests
import json
import os

my_secret = os.environ['Api']



response = requests.post(
  url="https://openrouter.ai/api/v1/chat/completions",
  headers={
    "Authorization": f"Bearer {my_secret}",
    #"HTTP-Referer": f"{YOUR_SITE_URL}", # Optional, for including your app on openrouter.ai rankings.
    #"X-Title": f"{YOUR_APP_NAME}", # Optional. Shows in rankings on openrouter.ai.
  },
  data=json.dumps({
    "model": "openchat/openchat-7b", # Optional
    "messages": [
      {"role": "user", "content": "OUTPUT A SINGLE SENTENCE STEREOTYPIC HALLMARK STORY. ALONG THE LINES OF: Someone goes somewhere for some reason, and they reemeet someone and they fall in love, also the random guy in town is probably the real santa clause. Examples: Simply output the story and nothing else, begin now: "}
    ]
  })
)

response_json = response.json()

assistant_response = response_json['choices'][0]['message']['content']

assistant_response = assistant_response[1:]
print(assistant_response)
