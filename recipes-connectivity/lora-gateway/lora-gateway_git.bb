SUMMARY = "lora-gateway"
SECTION = "apps"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=a2bdef95625509f821ba00460e3ae0eb"

DEPENDS_${PN} = "libmpsse"

do_compile[depends] = "libmpsse:do_populate_sysroot"

PR = "r0"

SRCREV = "0642acb11d56150f619d76f809fdfa48280df80e"

SRC_URI = " \
    git://github.com/mirakonta/lora_gateway.git;protocol=git;branch=master \
"

S = "${WORKDIR}/git"

CFLAGS += "-Iinc"

do_compile() {
  oe_runmake
}

do_install () {
    install -d ${D}${libdir}
    install ${S}/libloragw/libloragw.a ${D}${libdir}
    install -d ${D}${includedir}/libloragw
    install ${S}/libloragw/inc/*.h ${D}${includedir}/libloragw
    install -d ${D}${sysconfdir}/udev/rules.d
    install -m 0644 ${S}/libloragw/99-libftdi.rules ${D}${sysconfdir}/udev/rules.d/libftdi.rules
}

FILES_${PN} = " \
    ${sysconfdir}/udev/rules.d/libftdi.rules \
"

FILES_${PN}-dev += " \
    ${includedir}/libloragw/*.h \
"

FILES_${PN}-staticdev += " \
    ${libdir}/*.a \
"
