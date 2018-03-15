# jmsTestProjekt Mohamed
ein kleines Projekt, um Java Message Service zu testen.
# Entwicklung
JMS (Java Message Service) ist ein Java Message Oriented Middleware und er wird verwendet, damit die Komponente mit einander durch Messages kommunizieren können. Er funktioniert wie folgendes:
* Der Sender schickt ein Message zum Message Queue.
* Durch einen Listener detektiert der Empfänger die Anwesenheit vom Message, dann empfängt er das Message vom Queue.
* Das empfangene Message wird vom Queue gelöscht.
# Apache ActiveMQ
Um die Anwendung zum Laufen zu bekommen, muss man erstmal  Apache ActiveMQ: http://activemq.apache.org/activemq-5145-release.html .
