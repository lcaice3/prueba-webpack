#!/bin/bash

# Check that the environment variable has been set correctly
if [ -z "$SECRETS_BUCKET_NAME" ]; then
  echo >&2 'error: missing SECRETS_BUCKET_NAME environment variable'
  exit 1
fi

if  [ ${BDB_SECRETS_FILES_COUNT} != "0" ]; then

	AWS_ACCESS_KEY_ID=$BDB_AWS_ACCESS_KEY_ID
	AWS_SECRET_ACCESS_KEY=$BDB_AWS_SECRET_ACCESS_KEY
	AWS_ACCOUNT_ID=$BDB_AWS_ACCOUNT_ID

	aws configure set default.region us-east-1
	aws configure set default.output json

	# if  [ ${BDB_SECRETS_FILES_COUNT} = "2" ]; then
	# 	#echo 'secrets 2'
	# 	for attempt in {1..2}; do
	# 	    aws s3 cp s3://${SECRETS_BUCKET_NAME}/${BDB_SECRETS_FILE_NAME}-${attempt}.txt ${BDB_SECRETS_FILE_NAME}-${attempt}.txt
	# 	    aws kms decrypt --ciphertext-blob fileb://${BDB_SECRETS_FILE_NAME}-${attempt}.txt --output text --query Plaintext | base64 -d > keys-decrypted-${attempt}.txt
	# 		eval $(cat keys-decrypted-${attempt}.txt | sed 's/^/export /')
	# 	done
	# else
	# 	#echo 'secrets 1'
	# 	aws s3 cp s3://${SECRETS_BUCKET_NAME}/${BDB_SECRETS_FILE_NAME}.txt ${BDB_SECRETS_FILE_NAME}.txt
	# 	aws kms decrypt --ciphertext-blob fileb://${BDB_SECRETS_FILE_NAME}.txt --output text --query Plaintext | base64 -d > keys-decrypted-${BDB_SECRETS_FILES_COUNT}.txt
    #
	# 	eval $(cat keys-decrypted-${BDB_SECRETS_FILES_COUNT}.txt | sed 's/^/export /')
	# fi
	
fi


java -Djava.security.egd=file:/dev/./urandom -jar /app.jar