{ pkgs }: {
    deps = [
        pkgs.git
        pkgs.graalvm17-ce
        pkgs.maven
        pkgs.replitPackages.jdt-language-server
        pkgs.replitPackages.java-debug
        pkgs.python310Full
        pkgs.python310Packages.huggingface-hub
        pkgs.httpx
    ];
}