# atv_multicast_java
Um grupo de jornalistas deseja compartilhar as novidades do mundo dos Esportes e do
Entretenimento.
Considere a criação de grupos que funcione como um tipo de chat, onde os
interessados em um determinado tópico possam trocar mensagens. Essas mensagens devem
ser enviadas como datagramas por meio de sockets Multicast.
Para isso, também considere que:
a) Há apenas dois Tópicos possíveis:
● Entretenimento
● Esportes
b) Cada usuário deve informar:
● Um tópico de interesse
● Nome de usuário

c) Além disso, cada usuário deve ter acesso aos seguintes serviços:
● Envio de mensagens
Usuário deve informar o conteúdo da mensagem;
Cada mensagem enviada é uma string apresentando o seguinte formato:

[dd/MM/yyyy - HH:mm] Username : Body
Onde:
● dd/MM/yyyy - HH:mm : data e hora de envio da
mensagem;
● Username: nome informado pelo usuário;
● Body: conteúdo da mensagem.

Quando um usuário não desejar mais fazer parte do grupo, deve ser
digitado “SAIR”. Então, será propagado para os demais usuários que o
determinado usuário saiu do grupo e os serviços serão encerrados para o
usuário em questão.
● Recebimento de mensagens

Exibe todas as mensagens enviadas pelos participantes do tópico
(incluindo as mensagens enviadas pelo próprio usuário);

OBS.:
● Utilize Threads(Runnable) para que os serviços de envio e recebimento de mensagens
se mantenham ativos de forma simultânea;
● Mantenha esses dois serviços de forma “separada”:
○ Exemplo: o envio de mensagens pode ser realizado por uma caixa de diálogo
(JOptionPane), enquanto o recebimento de mensagens pode ser mantido no
terminal.

● Um determinado usuário deve receber mensagens apenas do tópico ao qual se
inscreveu.
