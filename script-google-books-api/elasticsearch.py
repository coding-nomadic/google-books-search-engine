import requests
import json


class ElasticsearchClient(object):

    # insert data to index
    @staticmethod
    def insert_index_books(elastic_url: str, index_name: str, item: dict):
        es_url = elastic_url+'/'+index_name+'/_doc'
        response = requests.post(es_url, json.dumps(item), headers={"Content-Type": "application/json"})
        if response.status_code == 201:
            print('Document successfully inserted')
        else:
            print(f'Error inserting document : {response.text}')


