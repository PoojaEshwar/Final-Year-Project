ans = "ans"
# Create the INSERT INTO sql query
query = """SELECT * FROM activities WHERE category = '""" + ans + """';"""
print(query)