import tensorflow as tf
import numpy as np

# Define the training set
training_set = np.array([[1, 1, 1, 0, 0, 1],
                         [1, 1, 1, 0, 1, 1],
                         [0, 0, 0, 1, 0, 0],
                         [0, 0, 0, 1, 1, 0],
                         [0, 0, 1, 0, 0, 1],
                         [0, 0, 1, 0, 1, 1],
                         [0, 0, 1, 1, 0, 1],
                         [0, 0, 1, 1, 1, 1],
                         [0, 1, 0, 0, 0, 0],
                         [0, 1, 0, 0, 1, 0],
                         [0, 1, 0, 1, 0, 0],
                         [0, 1, 0, 1, 1, 0],
                         [0, 1, 1, 0, 0, 1],
                         [0, 1, 1, 0, 1, 1],
                         [0, 1, 1, 1, 0, 1],
                         [0, 1, 1, 1, 1, 1],
                         [1, 0, 0, 0, 0, 1],
                         [1, 0, 0, 0, 1, 1],
                         [1, 0, 0, 1, 0, 1],
                         [1, 0, 0, 1, 1, 1],
                         [1, 0, 1, 0, 0, 1],
                         [1, 0, 1, 0, 1, 1],
                         [1, 0, 1, 1, 0, 1],
                         [1, 0, 1, 1, 1, 1]])

# Define the testing set
testing_set = np.array([[1, 1, 0, 0, 0, 1],
                        [1, 1, 0, 0, 1, 1],
                        [0, 0, 0, 0, 0, 0],
                        [0, 0, 0, 0, 1, 0],
                        [1, 1, 0, 1, 0, 1],
                        [1, 1, 0, 1, 1, 1],
                        [1, 1, 1, 1, 0, 1],
                        [1, 1, 1, 1, 1, 1]])

# Split the training set into input features (X) and target outputs (y)
X_train = training_set[:, :5]
y_train = training_set[:, 5]

# Define the neural network architecture
model = tf.keras.Sequential([
    tf.keras.layers.Dense(8, activation='relu', input_shape=(5,)),
    tf.keras.layers.Dense(4, activation='relu'),
    tf.keras.layers.Dense(1, activation='sigmoid')
])

# Compile the model
model.compile(optimizer='adam', loss='binary_crossentropy', metrics=['accuracy'])

# Train the neural network
model.fit(X_train, y_train, epochs=100, batch_size=4)

# Evaluate the model on the testing set
X_test = testing_set[:, :5]
y_test = testing_set[:, 5]
_, accuracy = model.evaluate(X_test, y_test)

print("Accuracy:", accuracy)
