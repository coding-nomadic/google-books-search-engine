import logging

import yaml


# reads configuration from yml file and loads as an object.
class config(object):
    def __init__(self, config_file: str):
        with open(config_file, 'r') as config_file_handle:
            properties = yaml.safe_load(config_file_handle)
        if properties is None:
            message = f'Could not to load properties from {config_file}'
            logging.error(message)
            raise Exception(message)
        if 'config' in properties:
            configs = properties['config']
            self.elastic_search_url = configs['elastic_search_url']
            self.index_name = configs['index_name']
            self.elastic_search_user = configs['elastic_search_user']
            self.elastic_search_password = configs['elastic_search_password']
            self.google_books_api_url = configs['google_books_api_url']
            self.google_books_api_key = configs['google_books_api_key']
            self.is_valid = True
        else:
            logging.error(f'Field \'config\' is missing in {config_file}')
            self.is_valid = False
