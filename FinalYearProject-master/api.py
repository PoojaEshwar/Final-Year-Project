import json
import MySQLdb as sql
from flask import Flask
from flask import jsonify
from flask import request
import surveyanalysis
import MySQLdb
import temperaturemodule



app = Flask(__name__)

@app.route('/appname/activity/<float:age>/<float:salary>/<float:budget>',methods=['POST'])

def predict_activity(age,salary,budget):


    print(str(age) +" "+ str(salary) +" "+str(budget))
    # ans = surveyanalysis.categorize(20, 4, 1000)
    ans = surveyanalysis.categorize(age,salary,budget)
    print("The predicted category is "+ans[0])
    res = []
    # temp = temperaturemodule.current_temperature()
    temp = 32.0
    print("Temperature :" + str(temp))

    # Create the SELECT sql query
    if(temp > 0.0 and temp < 35.0):
        query = """SELECT * FROM activities WHERE category = '""" + ans[0] + """';"""
    else:
        query = """SELECT * FROM activities WHERE category = '""" + ans[0] + """' and i_o = 'I';"""

    print(query)
    try:
       # Establish a MySQL connection
       database = MySQLdb.connect(host="localhost", user="root", passwd="", db="activityDB")

       # Get the cursor, which is used to traverse the database, line by line
       cursor = database.cursor()


       cursor.execute(query)

       records = cursor.fetchall()


       for row in records:
        dict = {}
        dict["Act ID"] = row[0]
        dict["Category"] = row[1]
        dict["Name"] = row[2]
        dict["Area"] = row[3]
        dict["Description"] = row[4]
        dict["I/O"] = row[5]
        dict["File"] = row[6]
        res.append(dict)

       cursor.close()

    except sql.Error as e:
       print("Error while connecting to MySQL", e)

    cursor.close()
    database.commit()
    database.close()
    print("MySQL connection is closed")

    return jsonify(res)


if __name__ == '__main__':
 app.run()