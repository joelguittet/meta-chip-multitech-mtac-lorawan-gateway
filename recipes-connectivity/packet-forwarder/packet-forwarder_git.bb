SUMMARY = "packet-forwarder"
SECTION = "apps"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=22af7693d7b76ef0fc76161c4be76c45"

DEPENDS_${PN} = "lora-gateway"
RDEPENDS_${PN} = "libmpsse bash"

do_compile[depends] = "lora-gateway:do_populate_sysroot"

PR = "r0"

SRCREV = "92c84267b688a4c6f99a9335aaa228be24a7443e"

SRC_URI = " \
    git://github.com/mirakonta/packet_forwarder.git;protocol=git;branch=master \
    file://packet-forwarder \
    file://global_conf.json.patch \
"

S = "${WORKDIR}/git"

EXTRA_OEMAKE = "LGW_PATH=../../../../lora-gateway/git-r0/git/libloragw"

CFLAGS += "-Iinc"

do_compile() {
    oe_runmake
}

do_install() {
    install -d ${D}${sysconfdir}/init.d
    install -d ${D}${sysconfdir}/rc1.d
    install -d ${D}${sysconfdir}/rc2.d
    install -d ${D}${sysconfdir}/rc3.d
    install -d ${D}${sysconfdir}/rc4.d
    install -d ${D}${sysconfdir}/rc5.d
    install -m 0755 ${WORKDIR}/packet-forwarder ${D}${sysconfdir}/init.d/
    ln -sf ../init.d/packet-forwarder ${D}${sysconfdir}/rc1.d/K90packet-forwarder
    ln -sf ../init.d/packet-forwarder ${D}${sysconfdir}/rc2.d/K90packet-forwarder
    ln -sf ../init.d/packet-forwarder ${D}${sysconfdir}/rc3.d/K90packet-forwarder
    ln -sf ../init.d/packet-forwarder ${D}${sysconfdir}/rc4.d/K90packet-forwarder
    ln -sf ../init.d/packet-forwarder ${D}${sysconfdir}/rc5.d/S90packet-forwarder
    install -d ${D}${base_prefix}/opt/packet-forwarder
    install -m 0644 ${S}/basic_pkt_fwd/global_conf.json ${D}${base_prefix}/opt/packet-forwarder/global_conf.json
    install -m 0755 ${S}/basic_pkt_fwd/basic_pkt_fwd ${D}${base_prefix}/opt/packet-forwarder/basic_pkt_fwd
}

FILES_${PN} = " \
    ${sysconfdir}/init.d/packet-forwarder \
    ${sysconfdir}/rc1.d/K90packet-forwarder \
    ${sysconfdir}/rc2.d/K90packet-forwarder \
    ${sysconfdir}/rc3.d/K90packet-forwarder \
    ${sysconfdir}/rc4.d/K90packet-forwarder \
    ${sysconfdir}/rc5.d/S90packet-forwarder \
    ${base_prefix}/opt/packet-forwarder/global_conf.json \
    ${base_prefix}/opt/packet-forwarder/basic_pkt_fwd \
"

FILES_${PN}-dbg = " \
    ${base_prefix}/opt/packet-forwarder/.debug/basic_pkt_fwd \
"

INSANE_SKIP_${PN} += "installed-vs-shipped"
INSANE_SKIP_${PN} += "dev-deps"
