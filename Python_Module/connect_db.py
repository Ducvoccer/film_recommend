
'''
hàm drop_database: xóa dababase
hàm create_database: tạo mới database chưa tồn tại
hàm create_table_data: tạo mới 1 bảng tên là data
hàm select_all: select toàn bộ có trong bảng data
hàm select_link: select toàn bộ link và trả về mảng link

hàm insert: insert thông tin
'''

import pymysql

 
#init database
host = "127.0.0.1"
username = "voccer"
password = "ducquang"
database_name = "film_recommend"
table_name = "data"
 

def drop_database():
    try: 
        connection = pymysql.connect(host, username, password)
        with connection.cursor() as cs:
            query_drop_database = """drop database """ +  database_name
            cs.execute(query_drop_database)
    
    finally:
        connection.close()
    
 
 #create new database with name: database_name
def create_database():
    try:
        connection = pymysql.connect(host, username, password)
        with connection.cursor() as cs:
            query_create_db = "create database if not exists " + database_name
            cs.execute(query_create_db)
          
    finally:
        # close connection
        connection.close()
def get_connect():
    try:
        connection = pymysql.connect(host, username, password, database_name)
        connection.autocommit(True)
        return connection
    except:
        print("connect fail")


def create_table_data():
    try:
        connection = get_connect()
        with connection.cursor() as cs:
            query_create_table = """
               create table if not exists data(
                    id int primary key auto_increment,
                    name text not null,
                    link text not null,
                    date text,
                    description text,
                    total_comment int,
                    nagative_comment int,
                    positive_comment int,
                    avg_cmt_point double,
                    avg_star_point double,
                    start_expert_point double,
                    characters text,
                    manufacturer text
                );
            """
            cs.execute(query_create_table)
    finally:
         # close connection
        connection.close() 
    
def select_all():
    try:
        connection = get_connect()
        with connection.cursor() as cs:
            query_select_all = """
                select * from data
            """
            cs.execute(query_select_all)
            
            for row in cs:
                print(row)
            return cs
    finally:
        # close connection
        connection.close()


def select_link():
    try:
        connection = get_connect()
        with connection.cursor() as cs:
            query_select_link = """
                select link from data
            """
            cs.execute(query_select_link)
            for row in cs:
                print(row)
            return cs
    finally:
        connection.close()

data_insert = ("a", "a", "a", "c", 10, 10, 12, 12, 11, 11, "a", "a")

def insert():
    try:
        connection = get_connect()
        with connection.cursor() as cs:
            query_insert = """
                insert into data(name, link, date, description, total_comment,
                nagative_comment,  positive_comment, avg_cmt_point, avg_star_point, 
                start_expert_point, characters, manufacturer)
                values
                    (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s);
                  # ("a", "a", "a", "c", 10, 10, 12, 12, 11, 11, "a", "a"),
                    
            """
            cs.execute(query_insert, data_insert)
    finally:
        connection.close()
    
if __name__ == '__main__':
    #drop_database()
#     create_database()
#     create_table_data()
    insert()
    select_all()
    select_link()
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
 