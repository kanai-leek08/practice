import bottle
import bottle.ext.sqlite
from bottle import route, run, template

app = bottle.Bottle()
plugin = bottle.ext.sqlite.Plugin(dbfile='sqlite.db')
app.install(plugin)


@app.route('/')
def top(db):
    user = db.execute('select * from users').fetchone()
    return template('top', user=user)


app.run(host='localhost', port=8080, debug=True, reloader=True)
