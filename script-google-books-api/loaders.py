from constants import SUBJECTS, BEST_SELLER, MAX_SEARCH
from elasticsearch import ElasticsearchClient
from googleapi import GoogleBooks
from main import load_configuration


class Loaders(object):

    @staticmethod
    def load_books_by_subject(subject, app_config):
        try:
            data_items = GoogleBooks.call_book_api(
                app_config.google_books_api_url,
                subject, MAX_SEARCH,
                app_config.google_books_api_key)

            for item in data_items:
                ElasticsearchClient.insert_index_books(
                    app_config.elastic_search_url,
                    app_config.index_name, item)

        except Exception as exception:
            print('An error occurred:', exception)

    @classmethod
    def load_books_for_all_subjects(cls):
        try:
            app_config = load_configuration()
            
            subjects_to_load = [BEST_SELLER, *SUBJECTS.values()]

            for subject in subjects_to_load:
                cls.load_books_by_subject(subject, app_config)
        except Exception as exception:
            print('An error occurred:', exception)
