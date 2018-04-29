# Customization of wpa-supplicant

# Files directory
FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

# Sources
SRC_URI_append = " \
    file://wpa_supplicant.conf-sane \
"
