## Quiz #17: Define the term encapsulation in the context of computer networks. [2]

## Proof of work:
Encapsulation is the process of adding protocol-specific headers, and sometimes trailers, to data as it moves down the layers of the TCP/IP (Transmission Control Protocol/Internet Protocol) model.
For example, the transport layer adds a TCP header to HTTP data to form a TCP segment, and the internet layer adds an IP (Internet Protocol) header to form an IP packet.

## Quiz #18: State the fundamental technologies required for a VPN service. [2]

## Proof of work:
The fundamental technologies required for a VPN (Virtual Private Network) are:
1. Encryption: the original packet is encoded so that it cannot be read if it is intercepted while travelling across the public internet.
2. Tunnelling: the original packet is encapsulated inside another packet, so that it can travel across the public internet to the VPN server, which removes the outer packet and delivers the original packet to the private network.

## Quiz #19: Identify one protocol used in the Application layer of the TCP/IP model. [2]

## Proof of work:
HTTP (Hypertext Transfer Protocol) is one protocol used in the application layer.
It is used to transfer web pages between a web server and a user's web browser, for example when the browser sends an HTTP GET request for a page.

## Quiz #20: Outline one step needed during preprocessing of a numerical database. [2]

## Proof of work:
One step needed during preprocessing of a numerical data set is a value (range) check, which ensures that each value is within a sensible range, such as a test score between 0 and 100.
Values outside this range are removed or flagged for manual checking, so that incorrect data does not reduce the accuracy of the model.

## Quiz #21: A marketing firm uses ML to analyze customer survey data. Describe one common issue in survey data that would require data preprocessing. [4]

## Proof of work:
A common issue in survey data is improperly formatted qualitative answers, where customers write the same answer in different ways, such as "Yes", "yes", "Y" and "yeah".
This happens because open-text survey questions allow each customer to type freely.
ML (Machine Learning) algorithms need consistent, numerical input, so the model would treat these answers as different categories and could find patterns that are not real.
During preprocessing, the answers are transformed into one consistent format and then converted into numbers, such as Yes = 1 and No = 0, so that the data can be used to train the model.

## Quiz #22: A school is developing a ML model to predict students' performance based on data from previous academic years. Explain how data preprocessing can improve the outcomes of the ML model. [6]

## Proof of work:
Outlier detection uses Z-scores or the interquartile range to find grades that are far from the typical pattern, such as a score of 0 recorded because a student was absent from an exam.
These outliers can be removed or capped so that the model does not learn from unusual values, which makes its predictions more accurate.
Input validation checks every record using a format check (e.g. dates written as YYYY-MM-DD), a domain check (e.g. the subject must be in the school's subject list) and a value check (e.g. an IB grade must be between 1 and 7).
This removes incorrect data, because a model trained on errors learns those errors and makes poor predictions.
Duplicate records, such as a student entered twice after changing classes, are removed so that the model is not biased towards over-represented students.
Missing grades, such as records unavailable for students who transferred mid-year, are identified and handled using mean imputation or by removing incomplete records where appropriate. This ensures that missing values do not cause errors during model training.

## Quiz #23: A university is preparing an ML model for admission purposes using a dataset containing 50 different metrics from applicants. Explain how dimensionality reduction techniques could be used in this context. [6]

## Proof of work:
With 50 metrics, each applicant is a data point in 50 dimensions, so the data becomes sparse and the model struggles to find patterns; this is the curse of dimensionality.
A filter method can calculate the correlation between each metric and the outcome, such as later academic success, and remove metrics below a threshold, such as an applicant's ID number.
A wrapper method can then train the model on different subsets of the remaining metrics and keep the subset that produces the most accurate predictions.
Alternatively, PCA (Principal Component Analysis) can combine related metrics, such as several different test scores, into a smaller number of new features.
Using fewer features reduces overfitting, so the model makes reliable decisions about new applicants instead of memorizing past applicants.
It also reduces the data storage and processing time needed to train the model, which matters when the university receives thousands of applications.

## Quiz #24: Explain why k-fold cross-validation is used with the k-NN technique [3]

## Proof of work:
K-fold cross-validation divides the dataset into k equal folds and evaluates the model k times, each time using a different fold as the test set and the remaining folds as the training set, so every data point across the whole dataset is used for testing exactly once.
Averaging the k results gives a more reliable estimate of how well the K-NN model performs on unseen data than a single train/test split, so it shows whether the model works for the general dataset rather than only for one particular split.
This helps avoid overfitting, because each possible number of neighbours (k) is evaluated with cross-validation and the value with the highest average accuracy is chosen, rather than a very small k that fits the noise in the training data.
