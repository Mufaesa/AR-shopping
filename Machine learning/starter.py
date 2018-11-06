from machinelearningdata import Machine_Learning_Data
import numpy as np
import matplotlib.pyplot as plt
from sklearn.cluster import KMeans
from sklearn import linear_model
from sklearn import tree

# from sklearn.metrics import accuracy_score

def extract_from_json_as_np_array(key, json_data):
    """ helper functie om data uit de json te halen en om te zetten naar numpy array voor sklearn"""
    data_as_array = []
    for p in json_data:
        data_as_array.append(p[key])

    return np.array(data_as_array)


STUDENTNUMMER = "0909257"

assert STUDENTNUMMER != "123456", "Verander 0909257 in je eigen studentnummer"

print("STARTER CODE")

# maak een data-object aan om jouw data van de server op te halen
data = Machine_Learning_Data(STUDENTNUMMER)

# UNSUPERVISED LEARNING

# haal clustering data op
kmeans_training = data.clustering_training()

# extract de x waarden
X = extract_from_json_as_np_array("x", kmeans_training)

# print(X)

# slice kolommen voor plotten (let op, dit is de y voor de y-as, niet te verwarren met een y van de data)
x = X[..., 0]
y = X[..., 1]

# teken de punten
for i in range(len(x)):
    plt.plot(x[i], y[i], 'k.')  # k = zwart

plt.axis([min(x), max(x), min(y), max(y)])
plt.show()

# vind 4 clusters en kleur ze
kmeans = KMeans(n_clusters=4).fit_predict(X)

for i in range(len(x)):
    if kmeans[i] == 0:
        plt.plot(x[i], y[i], 'r.')
    if kmeans[i] == 1:
        plt.plot(x[i], y[i], 'b.')
    if kmeans[i] == 2:
        plt.plot(x[i], y[i], 'y.')
    if kmeans[i] == 3:
        plt.plot(x[i], y[i], 'g.')

plt.axis([min(x), max(x), min(y), max(y)])
plt.show()


# -------------------------------------------------------------------------------------

# SUPERVISED LEARNING

# haal data op voor classificatie
classification_training = data.classification_training()

# extract de data x = array met waarden, y = classificatie 0 of 1
X = extract_from_json_as_np_array("x", classification_training)
Y = extract_from_json_as_np_array("y", classification_training)

x = X[..., 0]
y = X[..., 1]

# Create linear regression object
regr = linear_model.LogisticRegression()

# Train the model using the training sets
regr_fit = regr.fit(X, Y)

# Make predictions using the testing set
regr_y_pred = regr_fit.predict(X)

for i in range(len(x)):
    if regr_y_pred[i] == 0:
        plt.plot(x[i], y[i], 'r.')
    if regr_y_pred[i] == 1:
        plt.plot(x[i], y[i], 'b.')

plt.axis([min(x), max(x), min(y), max(y)])
plt.show()


# Tree
x = X[..., 0]
y = X[..., 1]

tree_model = tree.DecisionTreeClassifier()

# Train the model using the training sets
tree_fit = tree_model.fit(X, Y)

# Make predictions using the testing set
tree_y_pred = tree_fit.predict(X)

for i in range(len(x)):
    if tree_y_pred[i] == 0:
        plt.plot(x[i], y[i], 'r.')
    if tree_y_pred[i] == 1:
        plt.plot(x[i], y[i], 'b.')

plt.axis([min(x), max(x), min(y), max(y)])
plt.show()




# haal data op om te testen
classification_test = data.classification_test()
# testen doen we 'geblinddoekt' je krijgt nu de Y's niet
X_test = extract_from_json_as_np_array("x", classification_test)

yPredictReg = regr_fit.predict(X_test)
dTreePredict = tree_fit.predict(X_test)

classification_test = data.classification_test(yPredictReg.tolist())
print("Classificatie accuratie (Regression): " + str(classification_test))

classification_test = data.classification_test(dTreePredict.tolist())
print("Classificatie accuratie (Decision tree): " + str(classification_test))



