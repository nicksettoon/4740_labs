#!/bin/sh


# Disable service: disable automatic startup, and make sure it is not running now
disable_service() {
	SERVICE=$1
    if [ -e /etc/init.d/$SERVICE ]; then 
        # disable automatic startup on boot
        sudo /sbin/chkconfig $SERVICE off
        
        # stop the service
        sudo /sbin/service $SERVICE stop
    fi
}

# Enable service: enable automatic startup, and make sure it is running now
enable_service() {
	SERVICE=$1
    if [ -e /etc/init.d/$SERVICE ]; then 
    
        # enable automatic startup on boot
        sudo /sbin/chkconfig $SERVICE on
        
        # avoid error by only starting service if it isn't already running
        sudo /sbin/service $SERVICE status >> /dev/null
        if [  $? -ne 0 ]; then sudo /sbin/service $SERVICE start; fi
    else
         echo "* Warning: Service $SERVICE not installed"
    fi
}


enable_service hbase-master
enable_service hbase-regionserver
enable_service hbase-rest
enable_service hbase-thrift
enable_service hbase-solr-indexer

