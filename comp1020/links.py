"""
Author: Bryan
Date: Jan 5, 2020
Purpose: Convert lectures directory list to JSON object.
  The output is fed into another process for grabbing their
  contents.
"""
import json
import os
"""
Sample Output: {"links": ["00_Intro", "01_Java", "02_OOP"]}
"""
filenames = sorted(os.listdir("./lectures"))
mydict = {}
mydict["links"] = filenames

json_str = json.dumps(mydict)
print(json_str)
