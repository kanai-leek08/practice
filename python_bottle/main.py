from bottle import route, run, template

@route('/hello')
def hello():
    return template('hello_template')

run(host='localhost', port=8080, debug=True)
