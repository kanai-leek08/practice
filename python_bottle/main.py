from bottle import route, run, template


@route('/')
def top():
    return template('top')

run(host='localhost', port=8080, debug=True, reloader=True)
