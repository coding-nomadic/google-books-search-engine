from config import config

properties_file = 'config.yml'


# load yml file as object
def load_configuration():
    configs = config(properties_file)
    if configs.is_valid is False:
        return
    else:
        return configs


# main executor
def main():
    from loaders import Loaders
    print('####################### Best seller Books #######################')
    Loaders.load_best_seller_books()
    print('####################### Best seller Successfully Inserted #############')
    print('####################### Science Books  #######################')
    Loaders.load_subject_science_books()
    print('####################### Science Books Inserted  #######################')
    print('####################### Religion Books  #######################')
    Loaders.load_subject_religion_books()
    print('####################### Religion Books Inserted  #######################')
    print('####################### Economic Books  #######################')
    Loaders.load_subject_economic_books()
    print('####################### Economic Books Inserted  #######################')
    print('####################### Classics Books  #######################')
    Loaders.load_subject_classics_books()
    print('####################### Classics Books Inserted  #######################')
    print('####################### Fantasy Books  #######################')
    Loaders.load_subject_fantasy_books()
    print('####################### Fantasy Books Inserted  #######################')
    print('####################### Action Books  #######################')
    Loaders.load_subject_action_books()
    print('####################### Action Books Inserted  #######################')
    print('####################### Adventure Books  #######################')
    Loaders.load_subject_adventure_books()
    print('####################### Adventure Books Inserted  #######################')
    print('####################### Comic Books  #######################')
    Loaders.load_subject_comic_books()
    print('####################### Comic Books Inserted  #######################')
    print('####################### Detective Books  #######################')
    Loaders.load_subject_detective_books()
    print('####################### Detective Books Inserted  #######################')
    print('####################### Mystery Books  #######################')
    Loaders.load_subject_mystery_books()
    print('####################### Mystery Books Inserted  #######################')
    print('####################### Fiction Books  #######################')
    Loaders.load_subject_fiction_books()
    print('####################### Fiction Books Inserted  #######################')
    print('####################### Horror Books  #######################')
    Loaders.load_subject_horror_books()
    print('####################### Horror Books Inserted  #######################')
    print('####################### Humour Books  #######################')
    Loaders.load_subject_humour_books()
    print('####################### Humour Books Inserted  #######################')
    print('####################### Fairy Tale Books  #######################')
    Loaders.load_subject_fairy_tales_books()
    print('####################### Fairy Tale Books Inserted  #######################')
    print('####################### Folk Tale Books  #######################')
    Loaders.load_subject_folk_tales_books()
    print('####################### Folk Tale Books Inserted  #######################')


if __name__ == '__main__':
    main()
