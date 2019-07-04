import xlrd
import MySQLdb

# Open the workbook and define the worksheet
book = xlrd.open_workbook("data.xlsx")
sheet = book.sheet_by_index(0)

# Establish a MySQL connection
database = MySQLdb.connect (host="localhost", user = "root", passwd = "", db = "activityDB")

# Get the cursor, which is used to traverse the database, line by line
cursor = database.cursor()

# Create the INSERT INTO sql query
query = """INSERT INTO activities (category, name, area, description, i_o, file) VALUES (%s, %s, %s, %s, %s, %s)"""

# Create a For loop to iterate through each row in the XLS file, starting at row 2 to skip the headers
for r in range(1, sheet.nrows):
		category		= sheet.cell(r,0).value
		name	= sheet.cell(r,1).value
		area			= sheet.cell(r,2).value
		description		= sheet.cell(r,3).value
		i_o		= sheet.cell(r,4).value
		file	= sheet.cell(r,5).value


		# Assign values from each row
		values = (category,name,area,description,i_o,file)

		# Execute sql Query
		cursor.execute(query, values)

# Close the cursor
cursor.close()

# Commit the transaction
database.commit()

# Close the database connection
database.close()

# Print results
print ("")
print ("All Done! Bye, for now.")
print ("")
columns = str(sheet.ncols)
rows = str(sheet.nrows)
print (columns + " " + rows )
