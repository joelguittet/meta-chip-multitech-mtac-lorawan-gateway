DESCRIPTION = "LoRaWAN Gateway"
LICENSE = "MIT"

require recipes-core/images/chip-image-minimal.bb

IMAGE_INSTALL += " \
    chip-packagegroup-wifi \
    ntp tzdata \
    openssh \
    libftdi \
    libmpsse \
    lora-gateway \
    packet-forwarder \
"
