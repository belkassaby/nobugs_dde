import numpy as np
'''
Derivative python script example
'''
def run(data, xaxis, **kwargs):
    result = np.gradient(data)
    output = {'data': result}
    output["xaxis"] = xaxis
    return output
