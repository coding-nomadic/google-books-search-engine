from config import config
from loaders import Loaders

properties_file = 'config.yml'

def load_configuration():
    configs = config(properties_file)
    if not configs.is_valid:
        return None
    return configs

def load_and_print_books(loader_method, book_category):
    print(f'####################### {book_category} Books #######################')
    loader_method()
    print(f'####################### {book_category} Books Inserted  #######################')

def main():
    app_config = load_configuration()
    if not app_config:
        print('Invalid configuration. Exiting...')
        return
    
    categories = {
        'Best seller': Loaders.load_best_seller_books,
        'Science': Loaders.load_subject_science_books,
        'Religion': Loaders.load_subject_religion_books,
        'Economic': Loaders.load_subject_economic_books,
        'Classics': Loaders.load_subject_classics_books,
        'Fantasy': Loaders.load_subject_fantasy_books,
        'Action': Loaders.load_subject_action_books,
        'Adventure': Loaders.load_subject_adventure_books,
        'Comic': Loaders.load_subject_comic_books,
        'Detective': Loaders.load_subject_detective_books,
        'Mystery': Loaders.load_subject_mystery_books,
        'Fiction': Loaders.load_subject_fiction_books,
        'Horror': Loaders.load_subject_horror_books,
        'Humour': Loaders.load_subject_humour_books,
        'Fairy Tale': Loaders.load_subject_fairy_tales_books,
        'Folk Tale': Loaders.load_subject_folk_tales_books,
    }

    for category, loader_method in categories.items():
        load_and_print_books(loader_method, category)

if __name__ == '__main__':
    main()
