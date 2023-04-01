meta-chip-multitech-mtac-lorawan-gateway
==

NextThingCo C.H.I.P. Yocto LoRaWAN Gateway.

This layer contains recipes to create a LoRaWAN Gateway based on C.H.I.P. and MTAC-LORA mini-PCIe board from Multitech in order to create a private LoRaWAN network.

This layer depends on the additional mandatory layers:
* meta-yocto
* meta-yocto-bsp
* meta-openembedded/meta-oe
* meta-openembedded/meta-python
* meta-openembedded/meta-networking
* meta-chip (from my GitHub https://github.com/joelguittet/meta-chip)


Hardware of the LoRaWAN Gateway
--

The Gateway is created using the MTAC-LORA board from Multitech (https://www.multitech.com/brands/multiconnect-mcard). It is mounted on a cheap USB to mini-PCIe adapter. However, because the total consumption of the MTAC-LORA and C.H.I.P. boards is too large, a separated 5 Volts supply is required to supply the MTAC-LORA board as shown on the following photo.

![hardware](https://github.com/joelguittet/meta-chip-multitech-mtac-lorawan-gateway/blob/master/hardware.jpg)


Software of the LoRaWAN Gateway
--

The Gateway is running a specific version of the packet forwarder available at https://github.com/mirakonta/packet_forwarder, forked from Semtech version and modified to be used with the MTAC-LORA board. The packet forwarder is using Semtech UDP protocol version 1 to communicate with the LoRaWAN server. More details about this protocol are available at https://github.com/mirakonta/packet_forwarder/blob/master/PROTOCOL.TXT.


Configuration of the LoRaWAN Gateway
--

The Gateway is currently configured with WiFi and communicate with a local and private LoRaWAN server.
* recipes-connectivity/wpa-supplicant/files/wpa_supplicant.conf-sane: specifies WiFi SSID and passphrase.
* recipes-connectivity/packet-forwarder/files/global_conf.json.patch: specifies the address of my LoRaWAN server (currently 192.168.1.20 - can be a hostname or IP address).

Additional parameters can be modified (Gateway ID for example), please refer to the packet forwarder repository for more details.


Using
--

The image "chip-image-chip-multitech-mtac-lorawan-gateway" should be generated and flashed to the C.H.I.P. board. The gateway is immediatly running. It has been tested with a free and open-source LoRaWAN server available at https://github.com/gotthardp/lorawan-server.

Details about generation and flashing of the image are available on my meta-chip layer at https://github.com/joelguittet/meta-chip.


Contributing
--

All contributions are welcome :-)

Use Github Issues to report anomalies or to propose enhancements (labels are available to clearly identify what you are writing) and Pull Requests to submit modifications.


References
--

* https://github.com/joelguittet/meta-chip
* https://github.com/mirakonta/packet_forwarder
* https://github.com/mirakonta/lora_gateway
* https://github.com/gotthardp/lorawan-server

Special thanks to Mirakonta who modified packet forwarder for use with MTAC-LORA board.
