# Example Python Code to Insert a Document 

from pymongo import MongoClient 
from bson.objectid import ObjectId 

#My password has an @ symbol
from urllib.parse import quote_plus


class AnimalShelter(object): 
    """ CRUD operations for Animal collection in MongoDB """ 

    def __init__(self): 
        # Initializing the MongoClient. This helps to access the MongoDB 
        # databases and collections. This is hard-wired to use the aac 
        # database, the animals collection, and the aac user. 
        # 
        # You must edit the password below for your environment. 
        # 
        # Connection Variables 
        # 
        USER = 'aacuser' 
        PASS = 'TerriblePassword12@' 
        HOST = 'localhost' 
        PORT = 27017 
        DB = 'aac' 
        COL = 'animals' 
        # 
        # Initialize Connection 
        # 
        uri = 'mongodb://{}:{}@{}:{}'.format(quote_plus(USER),   
            quote_plus(PASS), 
            HOST, PORT)
        
        self.client = MongoClient(uri)
        self.database = self.client[DB]
        self.collection = self.database[COL]

    # Create a method to return the next available record number for use in the create method
            
    # Complete this create method to implement the C in CRUD. 
    def create(self, data):
        if data is not None:
          try:
              self.collection.insert_one(data)
              return True
          except Exception as e:
              print(e)
              return False         
        else: 
            raise Exception("Nothing to save, because data parameter is empty") 

    # Create method to implement the R in CRUD.
    def read(self, query):
      try:
        cursor = self.collection.find(query)
        return list(cursor)
      except Exception as e:
        print(e)
        return []
    
    # creat method to implete U in crud/update method for project
    def update(self, query, new_values, multiple=False):
        if not query or not new_values:
            raise Exception("Cannot be empty")
        try: 
            if multiple:
                result = self.collection.update_many(query, {'$set': new_values})
            else:
                result = self.collection.update_one(query, {'$set': new_values})
            return result.modified_count # pymango required for assingment
        except Exception as e:
            print(e)
            return 0
    
    # ceate mehod to implement D in CRUD/ delete method for prohect
    def delete(self, query, multiple=False):
        if not query:
            raise Exception("Cannot be empty")
        try: 
            if multiple:
                result = self.collection.delete_many(query)
            else:
                result = self.collection.delete_one(query)
            return result.deleted_count # pymango required for assingment
        except Exception as e:
            print(e)
            return 0