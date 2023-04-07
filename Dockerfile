FROM ubuntu

RUN apt update

RUN apt install curl -y
RUN apt install wget
RUN apt install docker.io -y
RUN apt install docker-compose -y
RUN apt-get update && apt-get install -y \
    software-properties-common \
    unzip \
    curl \
    wget \
    xvfb
RUN apt-get install -y libglib2.0-dev
RUN apt-get install -y libconfig-dev
RUN apt-get install -y libnss3
RUN apt-get install -y libfontconfig1-dev

# Install Selenium. Do I Need Selenium-server if I have installed selenium to Ubuntu???!!!
RUN wget -N http://selenium-release.storage.googleapis.com/3.0/selenium-server-standalone-3.0.1.jar -P ~/
RUN mv -f ~/selenium-server-standalone-3.0.1.jar /usr/local/share/
RUN chmod +x /usr/local/share/selenium-server-standalone-3.0.1.jar
RUN ln -s /usr/local/share/selenium-server-standalone-3.0.1.jar /usr/local/bin/selenium-server-standalone-3.0.1.jar

#Install Chrome
RUN wget https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb
RUN apt install ./google-chrome-stable_current_amd64.deb -y

#InstallChrome Driver
WORKDIR /usr/local/bin
#Autometic fatch current version of chromedriver
RUN google-chrome --version | grep -oE "[0-9]{1,10}.[0-9]{1,10}.[0-9]{1,10}" > /tmp/chromebrowser-main-version.txt
RUN wget --no-verbose -O /tmp/latest_chromedriver_version.txt https://chromedriver.storage.googleapis.com/LATEST_RELEASE_$(cat /tmp/chromebrowser-main-version.txt)
RUN wget --no-verbose -O /tmp/chromedriver_linux64.zip https://chromedriver.storage.googleapis.com/$(cat /tmp/latest_chromedriver_version.txt)/chromedriver_linux64.zip && rm -rf /opt/selenium/chromedriver && unzip /tmp/chromedriver_linux64.zip -d /opt/selenium && rm /tmp/chromedriver_linux64.zip && mv /opt/selenium/chromedriver /opt/selenium/chromedriver-$(cat /tmp/latest_chromedriver_version.txt) && chmod 755 /opt/selenium/chromedriver-$(cat /tmp/latest_chromedriver_version.txt) && ln -fs /opt/selenium/chromedriver-$(cat /tmp/latest_chromedriver_version.txt) /usr/bin/chromedriver
# RUN wget https://chromedriver.storage.googleapis.com/108.0.5359.71/chromedriver_linux64.zip
# RUN unzip chromedriver_linux64.zip



RUN apt-get update && \
    apt-get install -y openjdk-11-jdk && \
    apt-get install -y ant && \
    apt-get clean && \
    rm -rf /var/lib/apt/lists/ && \
    rm -rf /var/cache/oracle-jdk11-installer;

ENV JAVA_HOME /usr/lib/jvm/java-11-openjdk-amd64/
RUN export JAVA_HOME

ENV MAVEN_VERSION 3.3.9

RUN apt-get update && apt-get install -y curl git && rm -rf /var/lib/apt/lists/*

RUN mkdir -p /usr/share/maven /usr/share/maven/ref \
  && curl -fsSL http://apache.osuosl.org/maven/maven-3/$MAVEN_VERSION/binaries/apache-maven-$MAVEN_VERSION-bin.tar.gz \
    | tar -xzC /usr/share/maven --strip-components=1 \
  && ln -s /usr/share/maven/bin/mvn /usr/bin/mvn

ENV MAVEN_HOME /usr/share/maven
ENV MAVEN_CONFIG /home/seluser/.m2
ENV COPY_REFERENCE_FILE_LOG $MAVEN_CONFIG/copy_reference_file.log

ENV MAVEN_HOME /usr/share/maven
ENV MAVEN_CONFIG "$USER_HOME_DIR/.m2"

RUN apt-get update


# Install software 
RUN apt-get install -y git

RUN apt-get install -y ssh
# Make ssh dir
#RUN mkdir /root/.ssh/

# Copy over private key, and set permissions
# Warning! Anyone who gets their hands on this image will be able
# to retrieve this private key file from the corresponding image layer
#ADD id_rsa /root/.ssh/id_rsa

# Create known_hosts
# RUN touch /root/.ssh/known_hosts
# Add bitbuckets key
#RUN ssh-keyscan bitbucket.org >> /root/.ssh/known_hosts

# Clone the conf files into the docker container
#RUN git clone https://rahul1818:ATBBeqU3sHNXysLW89zhcRRLfJka265BF59E@bitbucket.org/#prospectasoftware/hybrid_ui_docker.git

#Making our working directory as /app

#COPY ./hybrid_ui_docker ./hybrid_ui_docker
#WORKDIR ./hybrid_ui_docker

ENTRYPOINT ["mvn", "clean", "verify"]

#RUN mvn clean verify