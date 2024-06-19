from models import Produto
from config import db


#delete tables all
db.drop_all()

#create tables all of databases
db.create_all()

#create a entity
tv = Produto(descricao='TV SAMSUNG', preco= 1990, quantidade=10)
#sem id
print(tv)

#salvar no banco
db.session.add(tv)        #idem: insert into Produto values.....
db.session.commit()

#com id
print(tv)

#alterando a descrição
tv.descricao = 'TV LG'
db.session.add(tv)
db.session.commit()

#cria outra entidade
fogao = Produto(descricao='Fogão 9 bocas', preco= 5400, quantidade=5)
db.session.add(tv)
db.session.commit()


#consulta todos os produtos cadastrados(SELECT * FROM PRODUTO)
produtos = Produto.query.all()
for p in produtos:
    print(p)

#buscando um unico item
porId = Produto.query.filter_by(id=1).first()
print('busca por id: ', porId)

porDescricao = Produto.query.filter_by(descricao='TV LG').all()
print('busca por descrição: ', porDescricao)

#apaga
produto = Produto.query.filter_by(id=1).first()
if produto:
    db.session.delete(produto)
    db.session.commit()
    print('apagou')

else:
    print('não apagou')