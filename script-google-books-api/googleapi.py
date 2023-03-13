import requests
import json


class GoogleBooks(object):

    @staticmethod
    def call_book_api(url: str, search: str, max_result: str, key: str):
        # Set the API endpoint and search parameters
        params = {
            "q": search,
            "maxResults": max_result,
            "key": key
        }
        # Make the API request
        response = requests.get(url, params=params)
        data = json.loads(response.text)
        return data["items"]

