# Customization of libftdi

# Files directory
FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

# Sources
SRC_URI_append = " \
    file://ftdi.h.patch \
"

# Install ftdi.h
do_install_append() {
  install -d ${D}${includedir}
  install -m 644 ${S}/src/ftdi.h ${D}${includedir}/ftdi.h
}
