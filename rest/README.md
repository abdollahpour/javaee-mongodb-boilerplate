Provider management
===================

GET /rest/providers
-------------------

Get list of providers

    {
        "page": PAGE
        "size": SIZE,
        "total": TOTAL,
        "totalPages": TOTAL_PAGES,
        "data": [
            {
                "name": "NAME",
                "ram": RAM,
                "cpu": CPU,
                "image": "IMAGE_NAME",
                "disk": "DISK"
            },
            ...
        ]
    }

* PAGE: Page number.
* SIZE: Size of items in the page.
* TOTAL: Total number of providers.
* TOTAL_PAGES: Total number of pages available.
* data.NAME: Provider unique name.
* data.RAM: The amount of RAM in Megabyte.
* data.CPU: Number of CPU.
* data.IMAGE: ISO image name for the server.
* data.DISK: Disk space in GB.


POST /rest/provider/${NAME}
---------------------------

* {NAME}: Provider unique name.

Add new config

    {
        "ram": RAM,
        "cpu": CPU,
        "image": "IMAGE_NAME",
        "disk": "DISK",
        "username": "USERNAME",
        "password": "PASSWORD",
        "key": "KEY"
    }

* RAM: The amount of RAM in Megabyte.
* CPU: Number of CPU.
* IMAGE: ISO image name for the server.
* DISK: Disk space in GB.
* USERNAME: (Optional) Username to access the provider.
* PASSWORD: (Optional) Password to access the provider.
* KEY: (Optional) Access key if it's required.


DELETE /rest/provider/${NAME}
-----------------------------
Delete specific configurations

* {NAME}: Provider unique name.


Rule management
===============

GET /rest/rules
---------------

Get list of defined rules.

    {
        "page": PAGE
        "size": SIZE,
        "total": TOTAL,
        "totalPages": TOTAL_PAGES,
        "more": MORE,
        "data": [
            {
                "name": "NAME",
                "countryCode": "COUNTRY_CODE",
                "city": "CITY",
                "image": "IMAGE",
                "servers": SERVERS,
                "max": MAX,
                "url": "URL"
            },
            ...
        ]
    }

* PAGE: Page number.
* SIZE: Size of items in the page.
* TOTAL: Total number of rules.
* TOTAL_PAGES: Total number of rules available.
* MORE: If it has mor pages.
* data.NAME: Rule unique name.
* data.COUNTRY_CODE: Country code (Ex: CN, US).
* data.CITY: City name (Ex: Beijing, Tehran).
* data.IMAGE: ISO image name.
* data.SERVERS: (Optional) Required servers. This is just available when URL does not exist.
* data.MAX: (Optional) Maximum number of servers. It is available when URL exists.
* data.URL: (Optional) You can feed rule dynamically from a URL:

        [
            {
                servers: SERVERS
                "countryCode": "COUNTRY_CODE",
                "city": "CITY"
            },
            ...
        ]
        
    * SERVERS: Number of servers required.
    * COUNTRY_CODE: Country code (Ex: CN, US).
    * CITY: City name (Ex: Beijing, Tehran).


GET /rest/rule/{NAME}
---------------------

* {NAME}: Name of the rule.

    {
        "name": "NAME",
        "countryCode": "COUNTRY_CODE",
        "city": "CITY",
        "image": "IMAGE",
        "servers": SERVERS,
        "max": MAX,
        "url": "URL"
    }
    
* NAME: Rule unique name.
* COUNTRY_CODE: Country code (Ex: CN, US).
* CITY: City name (Ex: Beijing, Tehran).
* IMAGE: ISO image name.
* SERVERS: (Optional) Required servers. This is just available when URL does not exist.
* MAX: (Optional) Maximum number of servers. It is available when URL exists.
* URL: (Optional) URL for feeding dynamically.

POST /rest/rule/{NAME}
----------------------

* {NAME}: Name of the rule.

*Model1:*

    {
        "name": "NAME",
        "image": "IMAGE",
        "max": MAX,
        "url": "URL"
    }
    
* NAME: Rule unique name.
* IMAGE: ISO image name.
* MAX: (Optional) Maximum number of servers. It is available when URL exists.
* URL: (Optional) URL for feeding dynamically.

*Model2:*

    {
        "name": "NAME",
        "countryCode": "COUNTRY_CODE",
        "city": "CITY",
        "image": "IMAGE",
        "servers": SERVERS
    }
    
* NAME: Rule unique name.
* location.COUNTRY_CODE: Country code (Ex: CN, US).
* location.CITY: City name (Ex: Beijing, Tehran).
* IMAGE: ISO image name.
* SERVERS: Required servers. This is just available when URL does not exist.


DELETE /rest/rule/{NAME}
------------------------

Delete rule.


Server management
=================

GET /rest/servers
-----------------

    {
        "page": PAGE
        "size": SIZE,
        "total": TOTAL,
        "totalPages": TOTAL_PAGES,
        "data": [
            {
                "id": ID,
                "provider": "PROVIDER",
                "image": "IMAGE",
                "instanceId": "INTANCE_ID",
                "start": "START",
                "end": "END",
                "lastCheck": "LAST_CHECK",
                "countryCode": "COUNTRY_CODE",
                "city": CITY
            },
            ...
        ]
    }

* PAGE: Page number.
* SIZE: Size of items in the page.
* TOTAL: Total number of servers.
* TOTAL_PAGES: Total number of servers available.
* data.ID: ID of the server.
* data.PROVIDER: Server provider name.
* data.IMAGE: Server image name.
* data.INSTANCE_ID: Instance ID of the server (Format is different for different providers).
* data.START: Start time.
* data.END: End time.
* data.LAST_CHECK: Last time server checked on provider.
* data.COUNTRY_CODE: Country code (Ex: CN, US).
* data.CITY: City name (Ex: Beijing, Tehran).

DELETE /rest/server/{ID}
------------------------

Try to delete server (It may not possible for some providers).

GET /rest/server/{ID}
---------------------

    {
        "id": ID,
        "provider": "PROVIDER",
        "image": "IMAGE",
        "instanceId": "INTANCE_ID",
        "start": "START",
        "end": "END",
        "lastCheck": "LAST_CHECK",
        "password": "PASSWORD",
        "countryCode": "COUNTRY_CODE",
        "city": CITY
    }

* ID: ID of the server.
* PROVIDER: Server provider name.
* IMAGE: Server image name.
* INSTANCE_ID: Instance ID of the server (Format is different for different providers).
* START: Start time.
* END: End time.
* LAST_CHECK: Last time server checked on provider.
* PASSWORD: Password of the default user (root mostly) in the server.
* data.COUNTRY_CODE: Country code (Ex: CN, US).
* data.CITY: City name (Ex: Beijing, Tehran).

Server status
=============

GET /rest/status/{SERVER_ID}
----------------------------

* SERVER_ID: (Option) ID of the server. If do not use SERVER_ID, you can list all the statuses.

    {
        "page": PAGE
        "size": SIZE,
        "total": TOTAL,
        "totalPages": TOTAL_PAGES,
        "more": MORE,
        "data": [
            {
                "statusCode": "PROVIDER",
                "serverId": "IMAGE",
                "capturedOn": "CAPTURE_ON",
                "cpu": "INTANCE_ID",
                "ram": "START"
            },
            ...
        ]
    }
    
* PAGE: Page number.
* SIZE: Size of items in the page.
* TOTAL: Total number of servers.
* TOTAL_PAGES: Total number of servers available.
* MORE: True if we have more pages.
* data.ID: ID of the status
* data.STATUS_CODE: creating/running/destroying
* data.SERVER_ID: ID of the server.
* data.CAPTURED_ON: Capturing date & time.
* data.CPU: (Optional) CPU Usage level if it be available.
* data.RAM: (Optional) RAM Usage level if it be available.