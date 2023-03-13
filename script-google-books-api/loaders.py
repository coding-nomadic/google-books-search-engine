from constants import BEST_SELLER, MAX_SEARCH, SUBJECT_SCIENCE, SUBJECT_RELIGION, SUBJECT_ECONOMICS, SUBJECT_CLASSICS, \
    SUBJECT_FANTASY, SUBJECT_ACTION, SUBJECT_ADVENTURE, SUBJECT_COMIC, SUBJECT_DETECTIVE, SUBJECT_MYSTERY, \
    SUBJECT_FICTION, SUBJECT_HORROR, SUBJECT_HUMOUR, SUBJECT_FAIRY_TALES, SUBJECT_FOLK_TALES
from elasticsearch import ElasticsearchClient
from googleapi import GoogleBooks
from main import load_configuration


class Loaders(object):

    # load only bestseller books in index elastic search
    @staticmethod
    def load_best_seller_books():
        try:
            app_config = load_configuration()
            data_items = GoogleBooks.call_book_api(app_config.google_books_api_url,
                                                   BEST_SELLER, MAX_SEARCH,
                                                   app_config.google_books_api_key)
            for item in data_items:
                ElasticsearchClient.insert_index_books(
                    app_config.elastic_search_url, app_config.index_name, item)
        except Exception as exception:
            print('An error occurred {}', exception)

    @staticmethod
    def load_subject_science_books():
        try:
            app_config = load_configuration()
            data_items = GoogleBooks.call_book_api(app_config.google_books_api_url,
                                                   SUBJECT_SCIENCE, MAX_SEARCH,
                                                   app_config.google_books_api_key)
            for item in data_items:
                ElasticsearchClient.insert_index_books(
                    app_config.elastic_search_url, app_config.index_name, item)
        except Exception as exception:
            print('An error occurred {}', exception)

    @staticmethod
    def load_subject_religion_books():
        try:
            app_config = load_configuration()
            data_items = GoogleBooks.call_book_api(app_config.google_books_api_url,
                                                   SUBJECT_RELIGION, MAX_SEARCH,
                                                   app_config.google_books_api_key)
            for item in data_items:
                ElasticsearchClient.insert_index_books(
                    app_config.elastic_search_url, app_config.index_name, item)
        except Exception as exception:
            print('An error occurred {}', exception)

    @staticmethod
    def load_subject_economic_books():
        try:
            app_config = load_configuration()
            data_items = GoogleBooks.call_book_api(app_config.google_books_api_url,
                                                   SUBJECT_ECONOMICS, MAX_SEARCH,
                                                   app_config.google_books_api_key)
            for item in data_items:
                ElasticsearchClient.insert_index_books(
                    app_config.elastic_search_url, app_config.index_name, item)
        except Exception as exception:
            print('An error occurred {}', exception)

    @staticmethod
    def load_subject_classics_books():
        try:
            app_config = load_configuration()
            data_items = GoogleBooks.call_book_api(app_config.google_books_api_url,
                                                   SUBJECT_CLASSICS, MAX_SEARCH,
                                                   app_config.google_books_api_key)
            for item in data_items:
                ElasticsearchClient.insert_index_books(
                    app_config.elastic_search_url, app_config.index_name, item)
        except Exception as exception:
            print('An error occurred {}', exception)

    @staticmethod
    def load_subject_fantasy_books():
        try:
            app_config = load_configuration()
            data_items = GoogleBooks.call_book_api(app_config.google_books_api_url,
                                                   SUBJECT_FANTASY, MAX_SEARCH,
                                                   app_config.google_books_api_key)
            for item in data_items:
                ElasticsearchClient.insert_index_books(
                    app_config.elastic_search_url, app_config.index_name, item)
        except Exception as exception:
            print('An error occurred {}', exception)

    @staticmethod
    def load_subject_action_books():
        try:
            app_config = load_configuration()
            data_items = GoogleBooks.call_book_api(app_config.google_books_api_url,
                                                   SUBJECT_ACTION, MAX_SEARCH,
                                                   app_config.google_books_api_key)
            for item in data_items:
                ElasticsearchClient.insert_index_books(
                    app_config.elastic_search_url, app_config.index_name, item)
        except Exception as exception:
            print('An error occurred {}', exception)

    @staticmethod
    def load_subject_adventure_books():
        try:
            app_config = load_configuration()
            data_items = GoogleBooks.call_book_api(app_config.google_books_api_url,
                                                   SUBJECT_ADVENTURE, MAX_SEARCH,
                                                   app_config.google_books_api_key)
            for item in data_items:
                ElasticsearchClient.insert_index_books(
                    app_config.elastic_search_url, app_config.index_name, item)
        except Exception as exception:
            print('An error occurred {}', exception)

    @staticmethod
    def load_subject_comic_books():
        try:
            app_config = load_configuration()
            data_items = GoogleBooks.call_book_api(app_config.google_books_api_url,
                                                   SUBJECT_COMIC, MAX_SEARCH,
                                                   app_config.google_books_api_key)
            for item in data_items:
                ElasticsearchClient.insert_index_books(
                    app_config.elastic_search_url, app_config.index_name, item)
        except Exception as exception:
            print('An error occurred {}', exception)

    @staticmethod
    def load_subject_detective_books():
        try:
            app_config = load_configuration()
            data_items = GoogleBooks.call_book_api(app_config.google_books_api_url,
                                                   SUBJECT_DETECTIVE, MAX_SEARCH,
                                                   app_config.google_books_api_key)
            for item in data_items:
                ElasticsearchClient.insert_index_books(
                    app_config.elastic_search_url, app_config.index_name, item)
        except Exception as exception:
            print('An error occurred {}', exception)

    @staticmethod
    def load_subject_mystery_books():
        try:
            app_config = load_configuration()
            data_items = GoogleBooks.call_book_api(app_config.google_books_api_url,
                                                   SUBJECT_MYSTERY, MAX_SEARCH,
                                                   app_config.google_books_api_key)
            for item in data_items:
                ElasticsearchClient.insert_index_books(
                    app_config.elastic_search_url, app_config.index_name, item)
        except Exception as exception:
            print('An error occurred {}', exception)

    @staticmethod
    def load_subject_fiction_books():
        try:
            app_config = load_configuration()
            data_items = GoogleBooks.call_book_api(app_config.google_books_api_url,
                                                   SUBJECT_FICTION, MAX_SEARCH,
                                                   app_config.google_books_api_key)
            for item in data_items:
                ElasticsearchClient.insert_index_books(
                    app_config.elastic_search_url, app_config.index_name, item)
        except Exception as exception:
            print('An error occurred {}', exception)

    @staticmethod
    def load_subject_horror_books():
        try:
            app_config = load_configuration()
            data_items = GoogleBooks.call_book_api(app_config.google_books_api_url,
                                                   SUBJECT_HORROR, MAX_SEARCH,
                                                   app_config.google_books_api_key)
            for item in data_items:
                ElasticsearchClient.insert_index_books(
                    app_config.elastic_search_url, app_config.index_name, item)
        except Exception as exception:
            print('An error occurred {}', exception)

    @staticmethod
    def load_subject_humour_books():
        try:
            app_config = load_configuration()
            data_items = GoogleBooks.call_book_api(app_config.google_books_api_url,
                                                   SUBJECT_HUMOUR, MAX_SEARCH,
                                                   app_config.google_books_api_key)
            for item in data_items:
                ElasticsearchClient.insert_index_books(
                    app_config.elastic_search_url, app_config.index_name, item)
        except Exception as exception:
            print('An error occurred {}', exception)

    @staticmethod
    def load_subject_fairy_tales_books():
        try:
            app_config = load_configuration()
            data_items = GoogleBooks.call_book_api(app_config.google_books_api_url,
                                                   SUBJECT_FAIRY_TALES, MAX_SEARCH,
                                                   app_config.google_books_api_key)
            for item in data_items:
                ElasticsearchClient.insert_index_books(
                    app_config.elastic_search_url, app_config.index_name, item)
        except Exception as exception:
            print('An error occurred {}', exception)

    @staticmethod
    def load_subject_folk_tales_books():
        try:
            app_config = load_configuration()
            data_items = GoogleBooks.call_book_api(app_config.google_books_api_url,
                                                   SUBJECT_FOLK_TALES, MAX_SEARCH,
                                                   app_config.google_books_api_key)
            for item in data_items:
                ElasticsearchClient.insert_index_books(
                    app_config.elastic_search_url, app_config.index_name, item)
        except Exception as exception:
            print('An error occurred {}', exception)
