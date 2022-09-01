<div class="container">
    <h1>Generate QR Code</h1>
    <form method="POST" enctype="multipart/form-data" action="/search">
        <div class="mb-3">
            <label for="qrContent" class="form-label">Enter your content to generate QR code</label>
            <input type="text" class="form-control form-control-lg" id="qrContent" name="qrContent" required>
        </div>
        <div class="mb-3">
            <button type="submit" class="btn btn-primary">Generate QR Code</button>
        </div>
    </form>
</div>